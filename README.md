### This project will be described with my weekly handin.

[![Build and deploy JAR app to Azure Web App - FastAndFuriousCars](https://github.com/MaltheGram/cars-r-us-startcode/actions/workflows/main_fastandfuriouscars.yml/badge.svg)](https://github.com/MaltheGram/cars-r-us-startcode/actions/workflows/main_fastandfuriouscars.yml)

<details>
 <summary>
  First handing / 4th Februrary 2022 - Learning basic <b>Annotations</b>
  </summary>
  <br>
  I've added the following Enities and Repositories for this first handin:
  <ul>
   <li> CarRepository </li>
   <li> MemberRepository </li>
   <li> Member Entity </li>
   <li> Car Entity </li>
   <br>
   
   I've added the Column annotation to most, if not all fields which serves as a way for the Database to know what columns should be named.
   Also the Entity classes have been annotated with @Entity(name = "xxx"), x serving as the name in the database.
   
   ### UnitTest
   In the test package I currently have 2 UnitTest's. They're testing if the count() from JpaRepository works. 
  
  
  </details>
 
 
 <details> 
  <summary> 
   Second hand / Februry 12th 2022 - Tests
  </summary>
  <br>
  In this hand in we've focused alot more attention onto tests.
  <br>
  The following kind of tests has been added to the repo.
  <ul>
   <li> In Memory Test </li>
   <li> Mock Test with Mockito </li>
   <li> Api Tests </li>
 </details> 
