package fr.univavignon.pokedex.api;

import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
	
	
	// contient les données des pokemons 
	private List<PokemonMetadata> metadata; 

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		if ( index < 0 || index>= metadata.size())
			throw new PokedexException(" Index incorrect");
		return metadata.get(index);
	}

}
