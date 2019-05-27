package ui;

/*Интерфейс для всех классов - действий.*/

public interface Action {
	
	//возвращает true если действие завершилось успехом, false если завершилось отменой
	boolean start();
}
