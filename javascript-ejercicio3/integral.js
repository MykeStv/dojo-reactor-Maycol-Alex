
//Funcion integra -> Según la teoria de integrales, es el limite de n->infinito de sumas de Riemann
function integral(f, a, b) {
    
    const n = 1_000_000 //tiende a infinito
    const deltaX = (b - a) / n //elemento diferencial

    let interval = range(a, b, n)

    let sum = 0 //suma

    interval.forEach(xi => {
        sum += f(xi)*deltaX
    });
    
    return sum;
}

//funcion range para crear n elements del intervalo definido por a y b.
function range (start, end, n) {
    let ans = []
    for(let i= start; i <= end; i += (1/n)) {
        ans.push(i);
    }
    return ans
}

//funcion a probar
const f1 = (x) => {
    return x**3;
}

//Prueba para un integral definida de la funcion f(x) = x^3
let test1 = integral(f1, 1, 2)
console.log(test1.toFixed(3))