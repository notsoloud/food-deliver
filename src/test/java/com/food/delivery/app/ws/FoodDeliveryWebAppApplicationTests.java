package com.food.delivery.app.ws;

import com.food.delivery.app.ws.io.entity.FoodEntity;
import com.food.delivery.app.ws.io.repository.FoodRepository;
import com.food.delivery.app.ws.io.repository.OrderRepository;
import com.food.delivery.app.ws.service.impl.FoodServiceImpl;
import com.food.delivery.app.ws.service.impl.OrderServiceImpl;
import com.food.delivery.app.ws.shared.dto.FoodDto;
import com.food.delivery.app.ws.shared.dto.OrderDto;
import org.hibernate.criterion.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodDeliveryWebAppApplicationTests {

	@InjectMocks
	FoodServiceImpl foodServiceImpl;

	@InjectMocks
	OrderServiceImpl orderServiceImpl;

	@Mock
	FoodRepository foodRepository;

	@Mock
	OrderRepository orderRepository;

	@Before
	public void setUp(){
		FoodEntity foodEntity1 = new FoodEntity();
		foodEntity1.setId(987654);
		foodEntity1.setFoodId("987654");
		foodEntity1.setFoodName("Pizza");
		foodEntity1.setFoodCategory("Fast food");
		foodEntity1.setFoodPrice(399);
		Mockito.when(foodRepository.save(any())).thenReturn(foodEntity1);
		Mockito.when(foodRepository.findByFoodId("987654")).thenReturn(foodEntity1);
		Mockito.when(foodRepository.findByFoodId("98765")).thenReturn(null);
	}

	@Test
	public void testFoodCreatedSuccess() {
		FoodDto foodDto1 = new FoodDto();
		foodDto1.setId(987654);
		foodDto1.setFoodId("987654");
		foodDto1.setFoodName("Pizza");
		foodDto1.setFoodCategory("Fast food");
		foodDto1.setFoodPrice(399);
		FoodDto rFoodDto1 = foodServiceImpl.createFood(foodDto1);
		assert(rFoodDto1.getId() == 987654);
		assert(rFoodDto1.getFoodId().equals("987654"));
		assert(rFoodDto1.getFoodName().equals("Pizza"));
		assert(rFoodDto1.getFoodCategory().equals("Fast food"));
		assert(rFoodDto1.getFoodPrice() == 399);
	}

	@Test
	public void testGetFoodByIdSuccess() {
		FoodDto foodDto1 = new FoodDto();
		foodDto1.setId(987654);
		foodDto1.setFoodId("987654");
		foodDto1.setFoodName("Pizza");
		foodDto1.setFoodCategory("Fast food");
		foodDto1.setFoodPrice(399);
		FoodDto rFoodDto = foodServiceImpl.createFood(foodDto1);
		FoodDto rFoodDto1 = foodServiceImpl.getFoodById("987654");
		assert(rFoodDto1.getId() == 987654);
		assert(rFoodDto1.getFoodId().equals("987654"));
		assert(rFoodDto1.getFoodName().equals("Pizza"));
		assert(rFoodDto1.getFoodCategory().equals("Fast food"));
		assert(rFoodDto1.getFoodPrice() == 399);
		try{
			FoodDto rFoodDto2 = foodServiceImpl.getFoodById("98765");
		}
		catch (Exception e){
			assert(e.getMessage().equals("98765"));
		}
	}

//	@Test
//	public void testOrderCreatedSuccess() {
//		OrderDto orderDto = new OrderDto();
//		orderDto.setOrderId("1234");
//		orderDto.setId(12345);
//		orderDto.setCost(24.5F);
//		orderDto.setStatus(Boolean.TRUE);
//		orderDto.setUserId("3076");
//		String[] items = ["soap","chips"];
//		orderDto.setItems(items);
//		Mockito.when(orderRepository.save(any())).thenReturn(orderDto);
//		OrderDto response = orderServiceImpl.createOrder(orderDto);
//
//	}

}
