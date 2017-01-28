package com.desafio.fchacon.bc;

import com.desafio.fchacon.entity.Person;
import com.desafio.fchacon.util.Utils;
import com.desafio.fchacon.ws.wrapper.ResponseWrapper;

/**
 * @author Felipe Chacón
 *
 */
public class PersonBC extends BaseBC {
	
	public PersonBC() {}
	
	/**
	 * @author Felipe Chacón
	 * @param run: Rut de la persona
	 * @param fullName: Nombre completo de la persona
	 * @param birthDate: Fecha de nacimiento en formato dd-mm-yyyy ó dd/mm/yyyy
	 * @param gender: Sexo de la persona (m = masculino, f = femenino)
	 * @return: Retorna una entidad persona con los mismos datos de entrada, junto con la edad en años, meses y días.
	 */
	public static ResponseWrapper getAge(String run, String fullName, String birthDate, String gender) {
		
		ResponseWrapper response = new ResponseWrapper();
		
		//El run es obligatorio
		if(run == null || run.trim().isEmpty()) {
			response.setError("El campo 'run' es obligatorio.");
			return response;
		}
		
		//Validar rut
		if(!Utils.validateRun(run)) {
			response.setError("El campo 'run' ingresado es inválido.");
			return response;
		}
		
		//El nombre completo es obligatorio
		if(fullName == null || fullName.trim().isEmpty()) {
			response.setError("El nombre completo (campo 'fullName') es requerido.");
			return response;
		}
		
		//La fecha de nacimiento es obligatoria
		if(birthDate == null || birthDate.trim().isEmpty()) {
			response.setError("La fecha de nacimiento (campo 'birthDate') es obligatoria.");
			return response;
		}
		
		//Validar fecha de nacimiento
		if(!Utils.validateDate(birthDate)) {
			response.setError("La fecha de nacimiento (campo 'birthDate') es inválida. Debe tener formato dd-mm-aaaa ó dd/mm/aaaa.");
			return response;
		}
		
		//El sexo de la persona es obligatoria
		if(gender == null || gender.trim().isEmpty()) {
			response.setError("El sexo de la persona (campo 'gender') es obligatorio.");
			return response;
		}
		
		//Validar sexo de la persona
		if(gender == null || gender.trim().isEmpty() || (!gender.trim().equalsIgnoreCase("m") && !gender.trim().equalsIgnoreCase("f"))) {
			response.setError("El sexo de la persona (campo 'gender') es inválido. Debe ser 'm' para masculino o 'f' para femenino.");
			return response;
		}
		
		//Construir un objeto Persona
		Person person = new Person(run, fullName, birthDate, gender);
		
		response.setData(person);
		return response;
	}
}
