import React, { Component } from 'react';
import { ActivityIndicator, Button, FlatList, Text, View, TouchableOpacity} from 'react-native';

const requestHTTP = async () => {
  try {
    let response = await fetch('https://raw.githubusercontent.com/CArmenta5/Moviles/master/Friend3.json')
    let json = await response.json();
    return json.friends;

  } catch (error) {
  }
};


export default class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      data: [],
      isLoading: false
    };
  }

  getFriends = async() =>{
    var json =  await requestHTTP()
    console.log(json);

    this.setState({
      isLoading:true,
      data:json
    })
  }

  
  render() {
    const { data, isLoading } = this.state;
    if(this.state.isLoading){
      return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center', padding: 24 }}>
          <Button title="LOAD" onPress={() => {
            
            this.getFriends();

          }}></Button>
            <FlatList 
              data={data}
              keyExtractor={({ id }, index) => id.toString()}
              renderItem={({ item }) => (
                <TouchableOpacity onPress={() => alert(item.nombre + "\n" + item.hobby + "\n" + item.age + "\n" + item.phone + "\n" + item.address)}>
                  <Text style={{
                    textAlign: 'center',
                    fontWeight: 'bold',
                    fontSize: 20,
                    lineHeight: 40,
                    fontFamily: 'notoserif',
                    padding: 15,
                    borderBottomColor: 'blue',
                    borderBottomWidth: 2,
                    }} 
                    key = {item.id} >Name: {item.nombre} | Hobby: {item.hobby}</Text>
                </TouchableOpacity>
              )}
             
            />
        </View>
      );
    }else{
      return(
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center', padding: 24 }}>
          <Button title="LOAD" onPress={() => {
            
            this.getFriends();

          }}></Button>
        </View>
      );
    }
  }
};