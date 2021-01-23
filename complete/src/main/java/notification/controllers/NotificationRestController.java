package notification.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import notification.models.Notification;
import notification.models.NotificationItem;
import notification.services.NotificationService;

@RestController
@RequestMapping(value = "/api/v1/websocket")
public class NotificationRestController {
	
	@Autowired
	private NotificationService notificationService;
//	@Autowired
//	private SimpUserRegistry simpUserRegistry;
	
	@Operation(summary = "Get a list of notifications")
	@GetMapping("/getNotification")
	public ResponseEntity<Notification> getNotifications (HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) boolean updateFetch) {
		if(updateFetch) {
			return ResponseEntity.ok(notificationService.getFilteredNotificationsAndUpdateFetch("cywteow"));
		}
		else {
			return null;
		}
	}
	
	@Operation( summary = "get Next Notification by lastId")
	@GetMapping("/getNextNotification/{lastId}")
	public ResponseEntity<Notification> getNextNotification(HttpServletRequest request, HttpServletResponse response, @PathVariable String lastId) {
		return ResponseEntity.ok(notificationService.getNextNotification(""));
	}
	
	@Operation( summary = "Update the read property of a single notification")
	@PutMapping("/markAsRead")
	public void markAsRead(HttpServletRequest request, HttpServletResponse response, @RequestBody NotificationItem item) {
		notificationService.markAsRead(item);
	}
	
	@GetMapping("/test/{hello}")
	public String test(HttpServletRequest request, HttpServletResponse response, @PathVariable String hello) {
		System.out.println(hello);
		System.out.println("Received");
		return "Hello world!";
	}

}
