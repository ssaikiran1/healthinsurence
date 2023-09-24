package com.HealthInsurence.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.HealthInsurence.modals.Customer;
import com.HealthInsurence.modals.CustomerForm;

@Controller
public class AdminController {
	private List<Customer> customers;

	public AdminController() {
		// Initialize the sample data (you can replace this with your database logic)
		customers = new ArrayList<>();
		customers.add(new Customer(1, "John Doe", "1234567890", "123 Main St"));
		customers.add(new Customer(2, "Jane Smith", "9876543210", "456 Elm St"));
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String firstpage() {
		return "admin";
	}

	@GetMapping("/admin-dashboard")
	public String adminDashboard() {
		return "admin/admin-dashboard";
	}

	@GetMapping("/admin-view-customer")
	public String adminViewCustomer(Model model) {
		model.addAttribute("customers", customers);
		return "admin/viewCustomers";
	}

	@PostMapping("/update-customer")
	public String updateCustomer(@ModelAttribute("customerForm") CustomerForm customerForm, Model model) {
		
		return "admin/updateCustomers";
	}

	@GetMapping("/admin-view-policy")
	public String allPolicies() {
		return "admin/allpolicies";
	}

	@GetMapping("//admin-view-hospitals")
	public String allHospitals() {
		return "admin/allhospitals";
	}
}
