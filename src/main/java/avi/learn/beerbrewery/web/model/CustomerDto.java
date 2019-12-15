package avi.learn.beerbrewery.web.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	@Null
	private UUID customerId;
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String customerName;
	private String emailId;
}
