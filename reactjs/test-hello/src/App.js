import React, {useState} from "react";

const App = () => {
    const [temperatureValue, setTemperatureValue] = useState(10);
    const [temperatureColor, setTemperatureColor] = useState("cold");

    const increaseTemperature = () => {
        if (temperatureValue === 30) return;
        const newTemperature = temperatureValue + 1;
        if (newTemperature >= 15) {
            setTemperatureColor('hot')
        }
        setTemperatureValue(temperatureValue + 1)
    }
    const decreaseTemperature = () => {
        if (temperatureValue === 0) return;
        const newTemperature = temperatureValue - 1;
        if (newTemperature < 1) {
            setTemperatureColor('cold')
        }
        setTemperatureValue(temperatureValue - 1)
    }

    return (
        <div className="app-container">
            <div className="temperature-display-container">
                <div className={`temperature-display ${temperatureColor}`}>{temperatureValue}Độ</div>
            </div>
            <div className="button-container">
                <button onClick={() => increaseTemperature()}>+</button>
                <button onClick={() => decreaseTemperature()}>-</button>
            </div>
        </div>
    )
}

// import './App.css';
// import React, {Component} from "react";
//
// class App extends Component{
//   constructor(props) {
//     super(props);
//     this.state = {
//       count: 0
//     }
//   }
//   increment = () => {
//     this.setState({ count: this.state.count + 1})
//   }
//   decrement = () => {
//     this.setState({ count: this.state.count - 1})
//   }
//   render() {
//     return (
//         <div className="App">
//           <button onClick={this.increment} className="counter">+</button>
//           <button onClick={this.decrement} className="counter">-</button>
//           <h2>{this.state.count}</h2>
//         </div>
//     )
//   }
// }

export default App;
