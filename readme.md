# cours et tutoriaux
https://drive.google.com/drive/folders/1jTv7y_xCsOFmBSEmaaetwcj8SiSfAQip?usp=sharing


# Structure du projet en Java
* .gitignore
* src/
  * main/
    * java/
      * fr/imie/bank/
        * DateUtils.java (à remplir)
        * MainConsole.java (à remplir)
        * model/
          * Dao.java (fourni, pas besoin de modifier)
          * Person.java (à remplir)
          * PersonDao.java (fourni, pas besoin de modifier)
          * csv/
            * PersonDaoCsvImpl.java (à remplir)
            * PersonDaoSqlImpl.java (à remplir en semaine 2)

# Objectifs

* avoir une application Java de gestion des contacts (pour les nantais, contacts + comptes bancaires)
* afficher un menu à l'utilisateur par exemple : 

1) Lister les personnes 
2) Ajouter une personne 
0) Sortir de l'application 

  * en bonus la suppression d'une personne par id

  * pour l'ajout d'un contact, demander les infos suivantes : 
    * Prénom
    * Nom
    * Email
    * Date de naissance

  * pour l'affichage d'un contact, afficher les infos suivantes :
    * Id (Identifiant généré par la sauvegarde dans la bdd ou le CsvDaoImpl)
    * Prénom
    * Nom
    * Email
    * Date de naissance
    * Age

  * exemple : 
* Id Prénom     Nom        Email                     Date de naissance 
*  1 Anakin     Skywalker  anakin.skywalker@imie.fr  01/01/2001 
*  2 Luke       Skywalker  luke.skywalker@imie.fr    01/01/2002 
*  3 Leia       Organa     leia.organa@imie.fr       01/01/2003 
