package com.jcpdev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultRbSearch {
	private String ps_nick;
	private int pageSize;
	private int StartNo;
}
