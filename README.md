KATA Tennis

This Kata is about implementing a simple tennis game. I came up with it while thinking about Wii tennis, where they have simplified tennis, so each set is one game.

The scoring system is rather simple:

1. Each player can have either of these points in one game 0 15 30 40

2. If you have 40 and you win the ball you win the game, however there are special rules.

3. If both have 40 the players are deuce. a. If the game is in deuce, the winner of a ball will have advantage and game ball. b. If the player with advantage wins the ball he wins the game c. If the player without advantage wins they are back at deuce.


1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.

2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.

3. If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.

4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.


=================================================================

                        INFOS COMPLEMENTAIRES

2 versions d'implementation : 

v1 : 
 - Orienté sur la modélisation de TennisGame et des Players.
 - Utilisation de Vavr pour une approche un peu fonctionnelle

v2 : 
 - Orienté sur la modélisation des scores et des Players.
 Les scores portent leur conditions d'éligibilité
 
 
Les 2 implémentations peuvent être lancées via les main de RollandGarros et Winbledon
pour simuler des matchs aléatoires.

Tests : 

J'ai fait le choix d'utiliser des tests paramétrables pour limiter la duplication de code proche
Tout en séparant les 4 cas possibles de score (player, deuce, avantage, game)
Il aurait également été possible de faire 1 seul test paramétrable 
mais j'ai préféré séparer les cas fonctionnels pour identifier plus facilement le cas en erreur en cas d'echec du test.
