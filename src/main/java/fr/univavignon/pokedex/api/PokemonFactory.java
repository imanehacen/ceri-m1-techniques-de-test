package fr.univavignon.pokedex.api;

public class PokemonFactory  implements IPokemonFactory{

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		
		PokemonMetadataProvider provider = new PokemonMetadataProvider();
		PokemonMetadata metadata;
		try {
			metadata = provider.getPokemonMetadata(index);

			String name = metadata.getName(); 
			
			int attack = metadata.getAttack(); 
			int stamina = metadata.getStamina(); 
			int defense = metadata.getDefense(); 
			
			// je n'ai pas compris comment se calcul l'iv 
			double iv = 56; 
			
			return new Pokemon(index, name, attack, defense, stamina,cp,  hp, dust, candy, iv );
			
		} catch (PokedexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null; 
	}

}
