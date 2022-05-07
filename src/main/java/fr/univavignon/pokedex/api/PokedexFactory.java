package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory{

	@Override
	public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		// TODO Auto-generated method stub
		
	   return new Pokedex(metadataProvider,pokemonFactory);
	}

}
