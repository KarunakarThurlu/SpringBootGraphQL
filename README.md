#Query
{
getCustomers(customerId:1){
customerId
customerName
}
}
#Mutation
mutation{
saveCustomer(customer:{
customerName:"John",
customerPhoneNumber:"87765123",
customerAddress:[{
streetName:"stb1",
pinNumber: 123,
city:"RACT"

    },{
      streetName:"Losa",
      pinNumber: 453,
      city:"NEJ"
    }],
    customerAccountVerified:false,
    customerSignUpDate:"2022-06-03T04:46:54.761Z"
}){
customerName
customerAddress{
addressId
streetName
pinNumber
}
}
}