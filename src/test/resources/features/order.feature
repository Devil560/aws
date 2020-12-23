@UITest
Feature: smartbearsoftware demosite 
	In order to Automate the site
As a practice automation user
I want to connect with the smartbearsoftware Demo site application

Background: 
	Given User launch the browser and navigate to the application "Web"
	
@Search @Regression @Smoke
Scenario Outline: To check whether order gets created or not. 
	When on the landing page verifies Username Textbox, Password Textbox and Login button 
	And Login using the valid credentials such as username as "<username>" and password as "<password>" 
	And Verify the Welcome ‘USERNAME’ showing the name as needed 
	And navigate to the Orders page 
	And select any product from the list and enter the quantity as "<quantity1>" 
	And click the calculate button 
	And Verify the value displayed correctly for the quantity and price 
	And Enter the name as "<name>" and street as "<street>" and city as "<city>" and state as "<state>" and zip as "<zip>" for the order 
	And Enter a dummy credit card details including cardnumber as "<cardnumber>" and expirydate as "<expirydate>" 
	And click process and verify the confirmation message 
	And navigate to View all orders 
	And verify the presence of the order placed 
	And edit the same order by changing expirydate as "<expirydate1>" and type to visa 
	Then verify the presence of updated order 
	
	Examples: 
	
		| username | password | quantity1 | name | street | city | state | zip | cardnumber | expirydate | expirydate1 | 
		| Tester | test | 5 | sanchit | civil lines | bareilly | up | 243122 |  123456789012 | 06/19  | 12/19 |
		
		@Smoke
		Scenario Outline: To check whether order can be edited or not. 
			When on the landing pagee verifies Username Textbox, Password Textbox and Login button 
			And Login usingg the valid credentials such as username as "<username>" and password as "<password>" 
			And Verifyy the Welcome ‘USERNAME’ showing the name as needed 
			And navigatee to the Orders page 
			And select anyy product from the list and enter the quantity as "<quantity1>" 
			And click thee calculate button 
			And Verify the valuee displayed correctly for the quantity and price 
			And Enter the namee as "<name>" and street as "<street>" and city as "<city>" and state as "<state>" and zip as "<zip>" for the order 
			And Enter a dummy creditt card details including cardnumber as "<cardnumber>" and expirydate as "<expirydate>" 
			And click process and verifyy the confirmation message 
			And navigate to Vieww all orders 
			And verify the presencee of the order placed 
			And edit the samee order by changing expirydate as "<expirydate1>" and type to visa 
			And verify the presencee of updated order 
			When User will edit the order created in last scenario 
			And updates the zip code as "<city1>" and city as "<zip1>" 
			And Verify the updated details on view orders page 
			Then click on logout button and verify the same 
			
			Examples: 
			
				| username | password | quantity1 | name | street | city | state | zip | cardnumber | expirydate | expirydate1 | city1 | zip1 |
				| Tester | test | 5 | sanchit | civil lines | bareilly | up | 243122 |  123456789012 | 06/19  | 12/19 | delhi | 230222 |
				
				@smoke
				Scenario Outline:To verify products and related information on products page.
					When onn the landing pagee verifies Username Textbox, Password Textbox and Login button 
					And Loginn usingg the valid credentials such as username as "<username>" and password as "<password>" 
					And Verifyy the Welcome ‘USERNAME’ showing the name as neededd 
					And navigate to View all products page 
					And verify the products in the table 
					Then clickk on logout button and verify the same 
					
					Examples: 
					
						| username | password |
						| Tester | test |
						
