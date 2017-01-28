package com.desafio.fchacon.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.desafio.fchacon.entity.Age;

/**
 * @author Felipe Chacón
 *
 */
public class Utils {
	
	/**
	 * @author Felipe Chacón
	 * @param run: Rut de una persona (incluyendo dígito verificador). Se omiten puntos y guión.
	 * @return Retorna true si el rut es válido, false en caso contrario.
	 */
	public static boolean validateRun(String run) {
		boolean response = false;
		try {
			run = run.toUpperCase();
			run = run.replace(".", "");
			run = run.replace("-", "");
			int rutAux = Integer.parseInt(run.substring(0, run.length() - 1));
		 
			char dv = run.charAt(run.length() - 1);
		 
			int m = 0, s = 1;
			for (; rutAux != 0; rutAux /= 10)
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
		
			if (dv == (char) (s != 0 ? s + 47 : 75))
				response = true;
			
		} catch (Exception e) {}
		
		return response;
	}
	
	/**
	 * @author Felipe Chacón
	 * @param dateInput: Fecha a validar. Debe tener formato dd-mm-yyyy ó dd/mm/yyyy
	 * @return Retorna true si la fecha es válida (en formato y valor). False en caso contrario.
	 */
	public static boolean validateDate(String dateInput) {
		
		//Si no viene fecha, retornar false.
		if(dateInput == null || dateInput.trim().isEmpty())
			return false;
		
		//Si la fecha no tiene largo 10, retornar false.
		if(dateInput.length() != 10)
			return false;
		
		dateInput = dateInput.replace("-", "/");
		
		Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf.parse(dateInput);
            if(!dateInput.equals(sdf.format(date)))
                date = null;
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        return date != null;
	}
	
	/**
	 * @author Felipe Chacón
	 * @param birthDateInput
	 * @return Retorna un objeto Age que representa la edad en días, meses y años de una persona.
	 */
	public static Age calculateAge(String birthDateInput) {
		int years = 0;
		int months = 0;
		int days = 0;
		
		birthDateInput = birthDateInput.replace("-", "/");
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
	    Date birthDate;
	    try {
	    	birthDate = df.parse(birthDateInput);
	    } catch (ParseException e) {
	    	//Fecha inválida
	        e.printStackTrace();
	        return null;
	    }
		
		//Crear objeto Calendar para el día de nacimiento
		Calendar birthDay = Calendar.getInstance();
		birthDay.setTimeInMillis(birthDate.getTime());
		
		//Crear objeto Calendar para el día actual
		long currentTime = System.currentTimeMillis();
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(currentTime);
		
		//Obtener la diferencia en años
		years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
		int currMonth = now.get(Calendar.MONTH) + 1;
		int birthMonth = birthDay.get(Calendar.MONTH) + 1;
		
		//Obtener la diferencia en meses
		months = currMonth - birthMonth;
		
		//Si la diferencia de meses es negativa, reducir en 1 los años y calcular el número de meses
		if (months < 0) {
			years--;
			months = 12 - birthMonth + currMonth;
			if(now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
				months--;
		}
		else if(months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
			years--;
			months = 11;
		}
		
		//Calcular los días
		if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
			days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
		
		else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
			int today = now.get(Calendar.DAY_OF_MONTH);
			now.add(Calendar.MONTH, -1);
			days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
		}
		else {
			days = 0;
			if (months == 12) {
				years++;
				months = 0;
			}
		}
		
		//Crear un objeto Age 
		return new Age(days, months, years);
	}
}
