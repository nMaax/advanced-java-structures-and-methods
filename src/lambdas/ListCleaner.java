package lambdas;

import java.util.List;

@FunctionalInterface
public interface ListCleaner {
	
	List<?> listCleaner(List<?> list);
	
}
