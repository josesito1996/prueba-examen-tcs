package com.tcs.service.app.business.util;

public class Utils {

	public static double targetAmount(double sourceAmount, double targetValue, double sourceValue) {
		double target = (sourceAmount * targetValue) / sourceValue;
		return roundDecimals(target, 2);
	}

	private static double roundDecimals(double initValue, int numberOfDecimalPlaces) {
		double wholePart, result;
		result = initValue;
		wholePart = Math.floor(result);
		result = (result - wholePart) * Math.pow(10, numberOfDecimalPlaces);
		result = Math.round(result);
		result = (result / Math.pow(10, numberOfDecimalPlaces)) + wholePart;
		return result;
	}

}
