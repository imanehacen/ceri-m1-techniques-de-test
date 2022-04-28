package fr.univavignon.pokedex.api;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import org.junit.Assert;

public class IPokemonTrainerFactoryTest {
	
	


	
	// pour la creation du trainer 
	IPokedex pokedex; 
	
	// classe que l'on veut tester 
	IPokemonTrainerFactory trainerFactory; ;

	// resultat attendu 
	PokemonTrainer pTrainer;
	 
	// besoin pour create 
	IPokedexFactory factory; 
	
	
	@Before
	public void init() {
		//la classe que l'on veut mocker 
		pokedex = Mockito.mock(IPokedex.class);
		trainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
		factory = Mockito.mock(IPokedexFactory.class);
		
		// on creee l'instance que devra être crée 
		pTrainer = new PokemonTrainer("imane", Team.INSTINCT, pokedex);
		
	}
	
	
	@Test
	public void createTrainerTest() {
		
		
		
		// lorque j'appelle createTrainer je dois obtenir mon pTrainer 
		Mockito.doReturn(pTrainer).when(trainerFactory).createTrainer("imane", Team.INSTINCT, factory);
		
		
		
		// on veut un objet de la classe Pokemon Trainer
		Assert.assertEquals(pTrainer.getClass(), trainerFactory.createTrainer("imane", Team.INSTINCT, factory).getClass());
				
		// on s'attend a obtenir l'instance pTrainer
		Assert.assertEquals(pTrainer, trainerFactory.createTrainer("imane", Team.INSTINCT, factory));
		
		// on s'attend à obtenir imane 
		Assert.assertEquals("imane",trainerFactory.createTrainer("imane", Team.INSTINCT, factory).getName() );
		
		
		// on doit recuperer la bonne equipe  team.instinct 
		Assert.assertEquals(Team.INSTINCT, trainerFactory.createTrainer("imane", Team.INSTINCT, factory).getTeam());
		
		
		// on verifie qu'on obtient bien le bon pokedex 
		Assert.assertEquals(pokedex, trainerFactory.createTrainer("imane", Team.INSTINCT, factory).getPokedex());
		
		
		// on verifie que la methode size de pokedex fonctionne 
		Assert.assertEquals(pokedex.size(), trainerFactory.createTrainer("imane", Team.INSTINCT, factory).getPokedex().size());
		
		
	}
	

}
