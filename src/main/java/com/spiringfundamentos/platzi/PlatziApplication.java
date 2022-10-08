package com.spiringfundamentos.platzi;

import com.spiringfundamentos.platzi.Bean.BeanWithProperties;
import com.spiringfundamentos.platzi.Bean.MyBean;
import com.spiringfundamentos.platzi.Bean.MyBeanWithDependency;
import com.spiringfundamentos.platzi.component.ComponentDependency;
import com.spiringfundamentos.platzi.component.ComponentTwoImplement;
import com.spiringfundamentos.platzi.entity.User;
import com.spiringfundamentos.platzi.pojo.UserPojo;
import com.spiringfundamentos.platzi.repository.UserRepository;
import com.spiringfundamentos.platzi.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PlatziApplication implements CommandLineRunner {

	private final Log  log = LogFactory.getLog(PlatziApplication.class);

	 private ComponentDependency componentDependency;
	 private MyBean myBean;

	 private MyBeanWithDependency myBeanWithDependency;

	 private BeanWithProperties beanWithProperties;

	 private UserPojo userPojo;

	 UserRepository userRepository;

	 UserService userService;



	 @Autowired
	public PlatziApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, BeanWithProperties beanWithProperties, UserPojo userPojo, UserRepository userRepository, UserService userService) {
		this.componentDependency = componentDependency;
		this.myBean= myBean;
		this.myBeanWithDependency= myBeanWithDependency;
		this.beanWithProperties=beanWithProperties;
		this.userPojo =userPojo;
		this.userRepository =userRepository;
		this.userService= userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PlatziApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		 examples();
		createInDataBase();
//		examplesJPQL();
		saveWithErrorTransantional();

	}


	public void saveWithErrorTransantional(){

		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());

		List<User> users = Arrays.asList(test1,test2,test3,test4);


		try {
			userService.save(users);
		}catch (Exception e){
			log.error(e);
		}
	}

	public void examplesJPQL(){
		 log.info("search user by email" + userRepository.findByUserByEmail("isaias@domain.com")
				 .orElseThrow(()-> new RuntimeException("No se encontro al usuario")));

		userRepository.findByNameAndSort("Karen", Sort.by("id")
				.ascending()).stream()
				.forEach(user -> log.info("User with method findbynameandsort"+user));


		userRepository.findByName("Isaias")
				.stream()
				.forEach(user -> log.info("usuario with Query metohd findByName "+user));

		log.info(userRepository.findByNameAndEmail("Marisol","marisol@domain.com")
				.orElseThrow(()-> new RuntimeException("user not found")));

		userRepository.findByNameLike("%I%")
				.stream()
				.forEach(user -> log.info("findByNameLike"+user));

		userRepository.findByNameOrderById("Isaias")
				.stream()
				.forEach(user -> log.info("findByNameOrderById"+ user));

		userRepository.findByNameContaining("K")
				.stream()
				.forEach(user -> log.info("findByNameContaining"+user));

		log.info("findUsersByNameAndAndEmail"+userRepository.findUsersByNameAndAndEmail("Marisol","marco@domain.com")
				.orElseThrow(()-> new RuntimeException(" not found")));

		log.info("findUsersAndOrEmail"+userRepository
				.findUsersByNameOrAndEmail(null, "luis@domain.com")
				.orElseThrow(() -> new RuntimeException("user not found")));

		userRepository.
				findByBirthDateBetween(LocalDate.of(2021, 11,1),LocalDate.of(2021,11,30))
				.stream()
				.forEach(user ->  log.info("findByBirthDateBetween"+user));

		userRepository.findByNameLikeOrderByIdDesc("%Isa%")
				.stream()
				.forEach(user -> log.info("findByNameLikeOrderByIdDesc"+ user));

		userRepository.findByNameContainingOrderByIdDesc("Ka")
				.stream()
				.forEach(user -> log.info("findByNameContainingOrderByIdDes"+user));
	}


	public void createInDataBase(){
		User user1 = new User("Isaias", "isaias@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("Marisol", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Isaias", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Karen", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Karen", "luis@domain.com", LocalDate.of(2021, 11, 27));
		User user9 = new User("Isaias", "paola@domain.com", LocalDate.of(2021, 4, 10));

		List<User> users = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9);

		users.stream().forEach(userRepository::save);
	}

	public void examples(){
		componentDependency.saludar();
		myBean.saludar();
		myBeanWithDependency.printWithDependency();
		System.out.println(beanWithProperties.function());
		System.out.println(userPojo.getEmail()+" - "+ userPojo.getPassword());

//		try {
//			int number = 10/0;
//		}catch (Exception e){
//			log.error("hay un error al dividir 10 sobre 0"+ e);
//		}
	}
}
