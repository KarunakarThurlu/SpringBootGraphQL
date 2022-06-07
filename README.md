1. GraphQL is a query language for APIs and a runtime for fulfilling those queries with your existing data.
2. GraphQL provides a complete and understandable description of the data in your API.
3. It gives clients the power to ask for exactly what they need and nothing more.
![Screenshot from 2022-06-07 10-47-17](https://user-images.githubusercontent.com/58630029/172301508-4834ddd0-ecdb-438e-b1a6-8400bd6856c1.png)
   When you are using graphQL in SpringBoot you need to write schema file with extension .graphqls and put under          src/main/resources/graphql folder
   ![Screenshot from 2022-06-07 11-04-33](https://user-images.githubusercontent.com/58630029/172303607-0aad6214-4f27-45dd-8738-82d0d69edac0.png)
 
   For accessing Graphiql ui you need to add one property in applicaion.(properties OR yml) 
       i.e  spring.graphql.graphiql.enabled=true
       ![Screenshot from 2022-06-07 11-12-23](https://user-images.githubusercontent.com/58630029/172304485-e3889ff9-4551-4a09-9d57-cc558131f90f.png)
![Screenshot from 2022-06-07 11-12-38](https://user-images.githubusercontent.com/58630029/172304488-7d4c12f5-5d9e-46cc-b527-2fb063066cc6.png)

   
4. To work with GraphQL first need to understand scalar-types
5. GraphQL comes with a set of default scalar types out of the box:
     Int: A signed 32‐bit integer.
     Float: A signed double-precision floating-point value.
     String: A UTF‐8 character sequence.
     Boolean: true or false.
     ID: The ID scalar type represents a unique identifier, often used to refetch an object or as the key for a cache.
6. By using these scalar types we can write Query's and Mutation's.
   Defining type:
   ==============
          type Address{
                 addressId:ID!
                 streetName:String!
                 pinNumber:Int!
                 city:String!
           }
           
           type Customer{
                 customerId:ID!
                 customerName:String!
                 customerPhoneNumber:String!
                 customerAddress:[Address]!
                 customerSignUpDate:String!
                 customerAccountVerified:Boolean
           }
7. Writing Query's:- Query is similar (GET HTTP Method)
    type Query{
       getCustomerById(customerId:Int!):Customer
       getCustomers:[Customer]
    }
8. Writing mutations:- Mutations are similar to (POST,PUT,DELETE  HTTP methods)
    
    input  updateCustomerInput{
                customerId:ID!
                customerName:String!
                customerPhoneNumber:String!
                customerAddress:[addressInput]!
                customerSignUpDate:String!
                customerAccountVerified:Boolean
    }
    input addressInput{
                addressId:ID
                streetName:String!
                pinNumber:Int!
                city:String!
    }
    type Mutation{
                 saveAddress(address:addressInput) : Address
                 saveCustomer(customer:customerInput) : Customer
                 deleteCustomer(customerId:Int!):String
                 updateCustomer(customer:updateCustomerInput):Customer
    }
    
 
