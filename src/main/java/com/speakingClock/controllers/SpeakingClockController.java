package com.speakingClock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speakingClock.service.SpeakingClockService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/clock")
@CrossOrigin
public class SpeakingClockController {

	@Autowired
	private SpeakingClockService speakingClockService;

	@ApiOperation(value = "get current timings in words", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = " result"),
			@ApiResponse(code = 400, message = "something went wrong") })
	@GetMapping("/currentTiming")
	public ResponseEntity<Object> getCurrentTimingsInWords() {

		String result = speakingClockService.getCurrentTimingsInWords();

		if (result == null) {
			return ResponseEntity.status(400).body("something went wrong");
		} else {
			return ResponseEntity.status(200).body(result);
		}
	}

}
