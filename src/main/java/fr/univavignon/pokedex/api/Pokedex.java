package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
	
	private List<Pokemon> pokemons; 
	IPokemonMetadataProvider metadataProvider; 
	IPokemonFactory pokemonFactory;
	
	public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		this.metadataProvider = metadataProvider;
		this.pokemonFactory = pokemonFactory; 
		pokemons = new ArrayList<>();
	}
	


	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		
		return metadataProvider.getPokemonMetadata(index);
	}

	
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		return pokemonFactory.createPokemon(index, cp, hp, dust, candy); 
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return pokemons.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		pokemons.add(pokemon);
		return pokemons.size()-1;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		// TODO Auto-generated method stub
		if ( id >= 0 && id <= 150) {
			return pokemons.get(id);
		}
		else throw new PokedexException("Index non valide "); 
	}

	@Override
	public List<Pokemon> getPokemons() {
		// TODO Auto-generated method stub
		return pokemons;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		// TODO Auto-generated method stub
		List<Pokemon> listOrder = new ArrayList<>(pokemons);
		listOrder.sort(order);
        return listOrder;
	}

}
