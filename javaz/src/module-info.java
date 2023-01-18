module javaz {
	exports javaz.oop;
	exports javaz.basic;
	exports javaz.oop.rpg;
	exports javaz.api;


	requires java.desktop;
	requires java.sql;
//	requires java.base; //생략 가능
	requires utilz;			//외부 모듈 명시
}