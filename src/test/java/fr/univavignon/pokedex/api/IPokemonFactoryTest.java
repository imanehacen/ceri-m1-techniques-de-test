package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;


public  class IPokemonFactoryTest {
	
	
	// classe à tester 
	IPokemonFactory pokemonFactory; 
	
	/*
	 * pokemon attendu 
	 */
	Pokemon bulbizarre; 
	Pokemon aquali ; 
	
	
	@Before
	public void init() {
		// on mock la classe que l'on veut tester 
		pokemonFactory = Mockito.mock(IPokemonFactory.class);
		
		/**
		 * on initialise nos pokemons 
		 */
		bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
	}
	
	
	@Test
	public void createPokemonTest() {
		// si on donne ces données la, on crée bulbizarre
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
		// si on donne ces données la, on crée aquali
		Mockito.when(pokemonFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(aquali);
		
		
		/**
		 * on verifie que les pokemons cree par la methods createPokemon renvoie bien les bon 
		 * pokemons 
		 */
		Assert.assertEquals(bulbizarre, pokemonFactory.createPokemon(0, 613, 64, 4000, 4));	
		Assert.assertEquals(aquali, pokemonFactory.createPokemon(133,2729, 202, 5000, 4));	

	}
	
	
	

}
