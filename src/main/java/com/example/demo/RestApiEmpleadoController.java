package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Empleado;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class RestApiEmpleadoController {
	
	private final List<Empleado> empleados = new ArrayList<>(List.of(
	        new Empleado(1L, "Java", "Java Programming"),
	        new Empleado(2L, "Spring", "Spring Framework"),
	        new Empleado(3L, "Angular", "Angular Framework"),
	        new Empleado(4L, "React", "React Framework")
	    ));

	    @GetMapping(value = "/Empleados", produces = "application/json")
	    public List<Empleado> getEmpleados() {
	        return empleados;
	    }

	    @PostMapping(value = "/Empleados", consumes = "application/json", produces = "application/json")
		public Empleado addEmpleado(@RequestBody Empleado empleado) {
			// Generate new ID based on the highest existing ID
			Long newId = empleados.stream()
			                       .mapToLong(Empleado::getId)
			                       .max()
			                       .orElse(0L) + 1; 

			empleado.setId(newId);
			empleados.add(empleado);
			return empleado;
		}
	    @DeleteMapping("/Empleados/{id}")
		public String deleteEmpleado(@PathVariable Long id) {
			Optional<Empleado> empleado = empleados.stream()
			                                        .filter(e -> e.getId().equals(id))
			                                        .findFirst();
			
			if (empleado.isPresent()) {
				empleados.remove(empleado.get());
				return "Empleado with ID " + id + " deleted successfully.";
			} else {
				return "Empleado with ID " + id + " not found.";
			}
		}
}
