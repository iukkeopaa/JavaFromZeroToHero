//
//
//import java.util.List;
//import java.util.function.BiConsumer;
//
//
//
//public class BiConsumerPersonExample {
//
//	static void printPersonDetails() {
//		BiConsumer<String, List<String>> personConsumer = (name,hobbies) -> System.out.println(name +" "+hobbies);
//		BiConsumer<String, Double> salaryConsumer = (name,salary) -> System.out.println(name +" "+salary);
//
//		List<com.java8.features.repo.Person> personList = com.java8.features.repo.PersonRepository.getAllPersons();
//
//		//personList.forEach(per -> personConsumer.accept(per.getName(), per.getHobbies()));
//		personList.forEach(per -> {
//			personConsumer.accept(per.getName(), per.getHobbies());
//			salaryConsumer.accept(per.getName(),per.getSalary());
//		});
//	}
//
//	public static void main(String[] args) {
//		printPersonDetails();
//	}
//
//}
