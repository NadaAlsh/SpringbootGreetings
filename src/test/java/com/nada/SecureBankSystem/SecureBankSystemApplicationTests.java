package com.nada.SecureBankSystem;

import com.nada.SecureBankSystem.entity.UserEntity;
import com.nada.SecureBankSystem.repository.UserRepository;
import com.nada.SecureBankSystem.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SecureBankSystemApplicationTests {
		@MockBean
		private UserRepository userRepository; // we use mockBean on repo bc it's the part that 'talks' with the database

		@Autowired
		private UserService userService;

		@Test
		public void whenUsersPasswordIsLargerThan8Digit_thenSuccess(){

			UserEntity userEntity1 = new UserEntity();
			userEntity1.setName("Thaer");
			userEntity1.setPassword("987654");

			UserEntity userEntity2 = new UserEntity();
			userEntity2.setName("Nada");
			userEntity2.setPassword("123456");

			UserEntity userEntity3 = new UserEntity();
			userEntity3.setName("Razan");
			userEntity3.setPassword("5363532");

			List<UserEntity> mockUsersEntity = Arrays.asList(
				userEntity1, userEntity2, userEntity3);
			Mockito.when(userRepository.findAll()).thenReturn(mockUsersEntity);// mockito is used to make a copy

			//Act
			List<String> usersWithStrongPassword = userService.getAllUsersWithStrongPassword();

			// Assert
			List<String> expectedUsersWithStrongPassword = Arrays.asList("Thaer", "Nada");
			assertEquals(expectedUsersWithStrongPassword, usersWithStrongPassword);


	}


}
