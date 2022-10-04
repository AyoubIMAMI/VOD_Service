# VOD-RMI

## Requirement
- This project is built using Maven
- Java version is 18.0.2

## Description
### Server side
- Server offer to the client a IConnexion stub allwing him to call `login()` and `signIn()` methods.
- Once sucessfuly authentified, server provide the Client with the stub of the singelton of IVODService.
- VODService allows the client to `viewCatalog()` and `playmovie()`.
- The ISBN and the name of the movie are stored in the `MovieDesc.java` class.
- The content of the movie (the byte array) is stored int the extended class of Movie called `Movie.java`.
- `Movie.java`, `MovieDesc.java` & `Client.java` implement Serializable.
- JsonHelper uses the Jackson library to Serialize and Deserialize data from the server. 

### Client side
- Client can communicate with the Server by calling the `UserInterface.java`.
- `UserInterface.java` can handle login/register calls and viewCatalog/playmovie calls.
- By calling the Server distant IVODService `playmovie()` method and providing his IClientBox stub. Server can call the `Stream()` methods and stream the byte array.

## Information concering used ports

|             | Port |
|-------------|------|
| Registry    | 2000 |
| IConnexion  | 2001 |
| IVODService | 2002 |
| IClientBox  | 2003 |
