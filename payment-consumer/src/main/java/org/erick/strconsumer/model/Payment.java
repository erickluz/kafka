package org.erick.strconsumer.model;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idUser;
	private Long idProduct;
	private String cardNumber;
}
