package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor - 디아이 할때 필요 - 컨스트럭터 자동 생성
// @Getter - 게터메서드 자동 생성
// public - 
// private - 디아이 - 파이널 붙으면 세터 메서드 사용 못함
// private - 디아이 - 파이널 붙으면 세터 메서드 사용 못함
@RequiredArgsConstructor
@Getter
public class HelloLombok {
	private final String hello;
	private final int lombok;

// public - 
// HelloLombok - 컨스트럭터 자동생성되어 오브젝 생성
// System - 게터자동생성되서 출력 가능
// System - 게터자동생성되서 출력 가능
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("헬로", 5);
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
}
