package com.jcpdev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private int qc_idx;
	private int q_idx;
	private int a_idx;
	private String qc_content;
	private String a_nick;
	private String a_password;
}
