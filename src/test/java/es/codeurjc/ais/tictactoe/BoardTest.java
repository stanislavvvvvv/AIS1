package es.codeurjc.ais.tictactoe;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;


public class BoardTest {

	private Board tablero;
	
	
	@Test
	public void cellsWinner(){
		//Given
		tablero = new Board();
		//When
		tablero.enableAll();
		tablero.getCell(0).value="o";
		tablero.getCell(1).value="o";
		tablero.getCell(2).value="o";
		int [] arr=new int[] {0,1,2};
		
		//Then
		for(int i=0;i<3;i++) {
		assertEquals(tablero.getCellsIfWinner("o")[i],arr[i]);
		}
	}
	
	@Test
	public void cellsWinnerNull(){
		//Given
		tablero = new Board();
		
		//When
		tablero.enableAll();
		tablero.getCell(0).value="o";
		tablero.getCell(1).value="x";
		tablero.getCell(2).value="o";
		
		//Then
		assertEquals(tablero.getCellsIfWinner("o"),null);
	}
	
	@Test
	public void cellsDrawTrue() {
		//Given
		tablero = new Board();
		
		//When
		tablero.enableAll();
		tablero.getCell(0).value="x";
		tablero.getCell(1).value="o";
		tablero.getCell(2).value="x";
		tablero.getCell(3).value="x";
		tablero.getCell(4).value="o";
		tablero.getCell(5).value="o";
		tablero.getCell(6).value="o";
		tablero.getCell(7).value="x";
		tablero.getCell(8).value="x";
		
		//Then
		assertTrue(tablero.checkDraw());
		
	}
	
	@Test
	public void cellsDrawFalse() {
		//Given
		tablero = new Board();
		
		//When
		tablero.enableAll();
		tablero.getCell(0).value="x";
		tablero.getCell(1).value="o";
		tablero.getCell(2).value="x";
		tablero.getCell(3).value="x";
		tablero.getCell(4).value="o";
		tablero.getCell(5).value="o";
		tablero.getCell(6).value="o";
		tablero.getCell(7).value="x";
		tablero.getCell(8).value=null;
		
		//Then
		assertFalse(tablero.checkDraw());
		
	}
}
