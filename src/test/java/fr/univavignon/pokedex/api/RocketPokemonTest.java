package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RocketPokemonTest {
	
	// classe à tester 
	IPokemonFactory pokemonFactory; 
	
	/*
	 * pokemon attendu 
	 */
	Pokemon bulbizarre; 
	Pokemon aquali; 
	Pokemon bulbizarreTest; 
	Pokemon aqualiTest ; 
	
	
	@Before
	public void init() {
		// on mock la classe que l'on veut tester 
		pokemonFactory = new RocketPokemonFactory();
		
		/**
		 * on initialise nos pokemons 
		 */
		bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
        bulbizarreTest =  new Pokemon(0,"MISSINGNO",126,126,90,613,64,4000,4,1.0);
        aqualiTest = new Pokemon(133, "aqualiTest", 186, 186, 260, 2729, 202, 5000, 4, 1.0);

	}
	
	
	@Test
	public void createPokemonTest() {
	
			
		   /**
		    * Ici on verifie que les iv correspondent 
		    * Test error car Rocket donne manuellement 1 aux iv alors qu'ils devraient être calculer
		    */
		   Assert.assertEquals(aqualiTest.getIv(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getIv(), 0.0);
	       Assert.assertNotEquals(aquali.getIv(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIv(), 0.0);
	       
	    
	       
	       /**
	        * on creer un pokemon a partir de rockket 
	        */
	       Pokemon pokemon = pokemonFactory.createPokemon(0,613,64,4000,4);

	       
	       /**
	        * on verifie les affectations de map
	        */
	       Assert.assertEquals(bulbizarreTest.getIndex(),pokemon.getIndex());
	       Assert.assertEquals(bulbizarreTest.getName(),pokemon.getName());
	       
	       
	       /**
	        * si index >0 on peut avoir max 100
	        * sinon 1000
	        */
	       Assert.assertTrue(0 < pokemon.getAttack() && pokemon.getAttack() < 1000);
	       Assert.assertTrue(0 < pokemon.getDefense() && pokemon.getDefense() < 1000);
	       Assert.assertTrue(0 < pokemon.getStamina() && pokemon.getStamina() < 1000);

	       
	       /**
	        * on verifie les getters
	        */
	       Assert.assertEquals(bulbizarreTest.getCp(),pokemon.getCp());
	       Assert.assertEquals(bulbizarreTest.getHp(),pokemon.getHp());
	       Assert.assertEquals(bulbizarreTest.getDust(),pokemon.getDust());
	       Assert.assertEquals(bulbizarreTest.getCandy(),pokemon.getCandy());
	       
	       
	       

	}
	

}
