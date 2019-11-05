package com.luanpontes.hanoi.api;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.internalServerError;
import static spark.Spark.notFound;
import static spark.Spark.port;
import static spark.Spark.post;
import static com.luanpontes.hanoi.api.ApiMsgEnum.*;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.luanpontes.hanoi.model.Delivery;
import com.luanpontes.hanoi.service.RedisClient;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());	

	private static Gson gson = new Gson();

	private static RedisClient redis = new RedisClient();

	public static void main(String[] args) {

		port(8080);


		before((request, response) -> {
			logger.info(String.format("%s %s", request.requestMethod(), request.url()));
		});

		get("/", (request, response) -> "Welcome");
		
		get("/ping", (request, response) -> redis.ping());

		post("/delivery", (request, response) -> {

			String body = request.body();

			Delivery delivery = gson.fromJson(body, Delivery.class);

			redis.set(delivery.getDeliveryId(), gson.toJson(delivery).toString());

			response.status(HTTP_CREATED);

			return "";

		});

		get("/delivery/:deliveryId/step", (request, response) -> {

			String id = request.params(":deliveryId");

			String json = redis.get(id);

			if (json == null) {
				response.status(HTTP_NOT_FOUND);
				return MSG_NOT_FOUND;
			} else {
				Delivery delivery = gson.fromJson(json, Delivery.class);
				return gson.toJson(delivery);
			}
		});
		

		notFound((request, response) -> {
			response.status(HTTP_NOT_FOUND);
			return MSG_NOT_FOUND;
		});

		internalServerError((request, response) -> {
			response.status(HTTP_INTERNAL_ERROR);
			return MSG_INTERNAL_ERROR;
		});

		after((request, response) -> {
			response.type("application/json");
		});

	}

}
