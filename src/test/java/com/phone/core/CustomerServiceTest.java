/*
 * package com.phone.core;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.junit.MockitoJUnitRunner;
 * 
 * import com.phone.core.config.CountryConfiguration; import
 * com.phone.core.dto.CustomerDto; import com.phone.core.entity.CustomerEntity;
 * import com.phone.core.repository.CustomerRepository; import
 * com.phone.core.service.CustomerService; import
 * com.phone.core.service.CustomerServiceImpl;
 * 
 * @RunWith(MockitoJUnitRunner.class) public class CustomerServiceTest {
 * 
 * @InjectMocks private CustomerService customerService = new
 * CustomerServiceImpl();
 * 
 * @Mock private CustomerRepository customerRepo;
 * 
 * @Mock private CustomerMapper customerMapper;
 * 
 * @Mock private CountryConfiguration countryConfiguration;
 * 
 * 
 * @Test public void getAllEmployeesTest() { List<CustomerEntity> list = new
 * ArrayList<>();
 * list.add(CustomerEntity.builder().id(1).name("C1").phone("(237) 697151594").
 * build());
 * 
 * List<CustomerDto> list2 = new ArrayList<>(); CustomerDto c1 =
 * CustomerDto.builder().country("Cameroon").countryCode("237").customerName(
 * "C1").phone("697151594").build(); CustomerDto c2 =
 * CustomerDto.builder().country("Ethiopia").countryCode("251").customerName(
 * "C2").phone("914701723").build(); CustomerDto c3 =
 * CustomerDto.builder().country("Morocco").countryCode("212").customerName("C3"
 * ).phone("6007989253").build(); CustomerDto c4 =
 * CustomerDto.builder().country("Mozambique").countryCode("258").customerName(
 * "C4").phone("847651504").build(); CustomerDto c5 =
 * CustomerDto.builder().country("Uganda").countryCode("256").customerName("C5")
 * .phone("775069443").build();
 * 
 * list2.add(c5);list2.add(c4);list2.add(c3);list2.add(c2);list2.add(c1);
 * when(customerRepo.findAll()).thenReturn(list); //
 * when(customerService.getCustomers(0, 0, null, null, null)).thenReturn(list2);
 * 
 * assertEquals(5, customerService.getCustomers(0, 0, null, null, null)); }
 * 
 * }
 */