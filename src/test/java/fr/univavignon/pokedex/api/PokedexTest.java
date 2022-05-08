package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PokedexTest {
	

	// classe que l'on veut tester 
	Pokedex pokedex; 
	
	
	/**
	 * Les pokemons qui nous seront utile pour nos tests 
	 */
	 Pokemon aquali;
	 Pokemon bulbizarre;
	 List<Pokemon> pokemons; 
	 
	@Before
	public void init() {
		
		//la classe que l'on veut mocker 
		pokedex = Mockito.mock(Pokedex.class);
		
		// on initialise nos pokemons 
		bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
        
        // on creee la liste qui nous sera utile pour nos tess 
        pokemons = new ArrayList<>();
        
        
        // on ajoute nos pokemons à la liste
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
       
	}
	

	@Test
	public void voidSizeTest() {
		
		// on retourne la taille du tableau su on appelle pokedex size 
		Mockito.doReturn(pokemons.size()).when(pokedex).size();	
		
		// on verifie que la taille renvoyer est bien à 2 
		Assert.assertEquals(2, pokedex.size());
	}
	
	@Test 
	public void addPokemonTest() {
		
		Mockito.doReturn(pokemons.size() + 1).when(pokedex).addPokemon(Mockito.any(Pokemon.class));

        // on doit avoir la taille + 1
        Assert.assertEquals(3, pokedex.addPokemon(new Pokemon(0, "", 0, 0, 0,0,0,0, 0, 0.0)));
		
	}
	
	 @Test
	    public void getPokemonTest () throws PokedexException {
		 // j'ajoute des pokemons 
		 	
		 	
		 	
		 	// si je demande le pokemon dont l'index est 133 je retourne aquali
		 	Mockito.doReturn(aquali).when(pokedex).getPokemon(133);
		 	// si je demande le pokemon dont l'index est 0 je retourne bulbizarre
	        Mockito.doReturn(bulbizarre).when(pokedex).getPokemon(0);
	       
	        Mockito.doThrow(new PokedexException("Cet index n'existe pas ")).when(pokedex).getPokemon(Mockito.intThat(i -> i < 0 || i > 150));

	        // Doit renvoyer bulbizarre
	        Assert.assertEquals(bulbizarre, pokedex.getPokemon(0));
	        
	        // Doit renvoyer aquali 
	        Assert.assertEquals(aquali, pokedex.getPokemon(133));
	        
	        
	        /** 
	         * 
	         * TEST EXCEPTION 
	         * 
	         * 
	         * */
	        // positif 
	        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(183));
	        // negatif 
	        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-151));
    }
	 
	 @Test
    public void getPokemonsTest () {
        List<Pokemon> unmodifiableList = Collections.unmodifiableList(pokemons);
        
        // on retourne la liste unmodifiable lorsque l'on appel getPokemons 
        Mockito.doReturn(unmodifiableList).when(pokedex).getPokemons();
       
        
        // on verifie que les listes font la meme taille 
        Assert.assertEquals(pokemons.size(), pokedex.getPokemons().size());
        
        // on verifie que les pokemons sont bien présents et aux memes index 
        Assert.assertEquals(aquali, pokedex.getPokemons().get(1));
        Assert.assertEquals(pokemons.get(0), pokedex.getPokemons().get(0));
        
        
        // on verifie qu'on retourne bien une unmodifiable liste 
        Assert.assertEquals(unmodifiableList.getClass(), pokedex.getPokemons().getClass());
       

    }
	 
	 
	 @Test
	    public void getPokemonsSortedTest () {
		 
		 	/**
		 	 * On crée nos différents comparators 
		 	 */
	        PokemonComparators name = PokemonComparators.NAME;
	        PokemonComparators index = PokemonComparators.INDEX;
	        PokemonComparators cp = PokemonComparators.CP;
	        
	        
	        /**
	         * On crée differentes liste selon le comparator que l'on utilise 
	         */
	        List<Pokemon> listPokemonSortedByName = new ArrayList<>(pokemons);
	        listPokemonSortedByName.sort(name);
	        
	        List<Pokemon> listPokemonSortedByIndex = new ArrayList<>(pokemons);
	        listPokemonSortedByIndex.sort(index);
	        
	        List<Pokemon> listPokemonSortedByCp = new ArrayList<>(pokemons);
	        listPokemonSortedByCp.sort(cp);
	        
	        
	        
	        /**
	         * on appelle la methode getPokemons prenant en argument le comparator 
	         */
	        Mockito.doReturn(Collections.unmodifiableList(listPokemonSortedByName)).when(pokedex).getPokemons(name);
	        Mockito.doReturn(Collections.unmodifiableList(listPokemonSortedByIndex)).when(pokedex).getPokemons(index);
	        Mockito.doReturn(Collections.unmodifiableList(listPokemonSortedByIndex)).when(pokedex).getPokemons(cp);

	        
	        // On verifie que la liste commence bien par Bulbizarre
	        Assert.assertEquals("Aquali", pokedex.getPokemons(name).get(0).getName());
	        // On verifie que le premier index est bien 0
	        Assert.assertEquals(0, pokedex.getPokemons(index).get(0).getIndex());
	        // On verifie que le plus petit CP est bien 613
	        Assert.assertEquals(613, pokedex.getPokemons(cp).get(0).getCp());

	        // On verifie que la liste est de type unmodifiable 
	        Assert.assertEquals(Collections.unmodifiableList(new ArrayList<>()).getClass(), pokedex.getPokemons(name).getClass());
	        
	        
	       
	        // On verifie que l'on a perdu aucun element 
	        Assert.assertEquals(pokemons.size(), pokedex.getPokemons(name).size());
	    }
	 
	 
	 
	 

}
