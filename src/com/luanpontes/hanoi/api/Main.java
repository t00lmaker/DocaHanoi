package com.luanpontes.hanoi.api;

import static com.luanpontes.hanoi.api.ApiMsgEnum.MSG_INTERNAL_ERROR;
import static com.luanpontes.hanoi.api.ApiMsgEnum.MSG_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
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

import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.luanpontes.hanoi.model.Delivery;
import com.luanpontes.hanoi.model.Step;
import com.luanpontes.hanoi.service.DeliveryService;
import com.luanpontes.hanoi.service.RedisClient;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());	

	private static Gson gson = new Gson();

	private static RedisClient redis = new RedisClient();
	
	private static DeliveryService deliveryService = new DeliveryService();

	public static void main(String[] args) {

		port(8080);


		before((request, response) -> {
			logger.info(String.format("%s %s", request.requestMethod(), request.url()));
		});

		post("/delivery", (request, response) -> {

			String body = request.body();

			Delivery delivery = gson.fromJson(body, Delivery.class);
			
			List<String> errors = deliveryService.validate(delivery);
			
			if(errors.isEmpty()) {
				redis.set(delivery.getDeliveryId(), gson.toJson(delivery).toString());
				response.status(HTTP_CREATED);
			}else {
				response.body(gson.toJson(errors));
				response.status(HTTP_BAD_REQUEST);
			}
			

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
				List<Step> steps = deliveryService.stepsDoca(delivery);
				
				return gson.toJson(steps);
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
