[![codecov](https://codecov.io/gh/imanehacen/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=AEOUST68QF)](https://codecov.io/gh/imanehacen/ceri-m1-techniques-de-test)
[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://circleci.com/gh/circleci/circleci-docs)


Imane HACEN GRP1


Le projet contient une application permettant d'effectuer des parties de jeux de Pokemon.

L’idée est de stocker des informations sur des Pokémons, dans un conteneur qu’est le Pokédex. Dans le cadre de ce TP nous nous contenterons de la première génération, soit 151 espèces.

Une espèce de Pokémon est décrite par des métadonnées communes à chaque individu de l’espèce à savoir :

      Un index numérique (allant de 0 à 150)
      Un nom
      Un niveau d’attaque
      Un niveau de défense
      Un niveau d’endurance ou stamina
      Ces informations sont représentées par la classe PokemonMetadata. Les métadonnées décrivent une espèce, alors qu’un individu est défini par la classe Pokemon, défini par les attributs suivants :

      Un niveau de combat ou CP
      Un niveau de vie ou HP
      Un niveau de poussière d’étoile ou dust
      Un nombre de bonbon ou candy
      Un pourcentage de perfection
      Des métadonnées
      Les métadonnées d’un individu ne doivent pas être confondues avec les métadonnées de l’espèce. En effet, les valeurs des niveaux d’attaque, de défense, ou d’endurance sont bornées entre 0 et 15 dans le cadre d’un individu. Le niveau pour une statistique donnée se calcule ainsi :

      Niveau de base de l’espèce + Niveau de l’individu

Description des interfaces de notre système :

        IPokemonMetadataProvider est chargé pour un index donné de retourner les métadonnées d’une espèce.
        IPokemonFactory permet de créer un individu.
        IPokedex est notre conteneur, qui étend les deux interfaces précédentes, qu’il fournit à travers le pattern "Décorateur".
        IPokedexFactory permet de créer une instance de IPokedex.
        Un IPokedex appartient à un PokemonTrainer, défini par un nom et une équipe.
        Les PokemonTrainer sont créés à travers l’interface IPokemonTrainerFactory.
