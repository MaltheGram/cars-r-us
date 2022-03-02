### This project will be described with my weekly handin.

[![Build and deploy JAR app to Azure Web App - FastAndFuriousCars](https://github.com/MaltheGram/cars-r-us/actions/workflows/main_fastandfuriouscars.yml/badge.svg)](https://github.com/MaltheGram/cars-r-us/actions/workflows/main_fastandfuriouscars.yml)

<details>
 <summary>
  First hand-in / 4th Februrary 2022 - Learning basic <b>Annotations</b>
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
   Second hand-in / Februrary 12th 2022 - Tests
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
  
  
<details>
 <summary>
  Third hand-in / Februrary 18th 2022 - Full CRUD API for Member and Car classes
 </summary>
 <br>
 Made a full CRUD API for Member and Car. At this stage we're able to patch only a few fields for a Member / Car.
 <br>
Also started on CRUD for Reservation. This is TBC.
 <br>
 Should also be deployed to Azure.
  </details>
 
<details>
 <summary>
  Fourth hand-in / March 2nd 2022 - Docker container with MySQL
 </summary>
 <br>
 Deployed to Azure with a Docker container running on Ubuntu. Installed MySQL and the database is now stored on Azure.
  </details>
 

