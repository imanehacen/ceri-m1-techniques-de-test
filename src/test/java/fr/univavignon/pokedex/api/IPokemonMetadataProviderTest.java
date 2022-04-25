package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;



public  class IPokemonMetadataProviderTest {
	
	
	IPokemonMetadataProvider provider ;
	
	 PokemonMetadata aquali;
	 PokemonMetadata bulbizarre;

	
	@Before
	public void init() {
		provider = Mockito.mock(IPokemonMetadataProvider.class);
		bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
	}
	
	
	@Test
	public void getPokemonMetadataTest() throws PokedexException {
		
		// si on met index 133, le mock renvoie aquali
		Mockito.doReturn(aquali).when(provider).getPokemonMetadata(133);		
		
		// si on met index 0, le mock renvoie bulbizarre
		Mockito.doReturn(bulbizarre).when(provider).getPokemonMetadata(0);
		
		//  les données de bulbizarre sont attendu 
        Assert.assertEquals(bulbizarre, provider.getPokemonMetadata(0));
        
        // les données de aquali sont attendu 
        Assert.assertEquals(aquali, provider.getPokemonMetadata(133));
        
        
        /** 
         * TEST DES EXCEPTIONS 
         * 
         * */
        
     // si on met index superieur à 150 et inferieur à 0, on declenche une erreur 
     	Mockito.doThrow(new PokedexException("L'index fourni n'existe pas ")).when(provider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));
     	
        
        // On attend que les exceptions sont lancés 
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(-189));
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(313));
	}
	
	
}
