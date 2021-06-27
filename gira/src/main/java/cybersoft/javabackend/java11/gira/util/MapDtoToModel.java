package cybersoft.javabackend.java11.gira.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class MapDtoToModel<E extends Object, T extends Object> {
	public T map(E dto, T model) {
		Method[] dtoMethods = dto.getClass().getMethods();
		List<String> dtoGetters = new LinkedList<String>();
		
		
		for(Method method : dtoMethods) {
			if(!method.getName().equals("getClass") && method.getName().startsWith("get"))
				dtoGetters.add(method.getName());
		}
		
		for(String getter : dtoGetters) {
			try {
				Object dtoValue = dto.getClass().getMethod(getter).invoke(dto);
				
				String modelSetter = getter.replaceFirst("get", "set");
				
				Class<?>[] classes = model.getClass().getMethod(modelSetter).getParameterTypes();
//				classes[0] modelValue = (classes[0]) dtoValue;
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return model;
	}
}
