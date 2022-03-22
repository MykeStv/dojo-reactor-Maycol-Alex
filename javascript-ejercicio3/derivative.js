
// f = x^3
const f1 = (x) => {
    return Math.pow(x, 3)
}

function derivative(f, x) {
    let h = 0.0001;
    let dy = f(x + h) - f(x)
    let dx = h

    return dy/dx
}

// testing the function
console.log(derivative(f1, 3).toFixed(3))
