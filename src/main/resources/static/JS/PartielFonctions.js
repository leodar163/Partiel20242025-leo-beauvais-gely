window.onload = () => {
    afficherPageCommande();
};

async function afficherPageCommande() {
    //Clients
    const responseClients = await fetch("/clients");

    if (!responseClients.ok) {
        alert("impossible de récupérer les clients." +
            "\n inspectez la console pour plus d'informations");
        console.error(await responseClients.json());
    }

    const clients = await responseClients.json();


    //Livreurs
    const responseLivreurs= await fetch("/livreurs");

    if (!responseLivreurs.ok) {
        alert("impossible de récupérer les livreurs. " +
            "\n inspectez la console pour plus d'informations");
        console.error(await responseLivreurs.json());
    }

    const livreurs= await responseLivreurs.json();


    //Pizzas
    const responsePizzas= await fetch("/pizzas");

    if (!responsePizzas.ok) {
        alert("impossible de récupérer les pizzas. " +
            "\n inspectez la console pour plus d'informations");
        console.error(await responsePizzas.json());
    }

    const pizzas= await responsePizzas.json();


    //Commande number
    const responseCommandeNumber = await fetch("/commandes/number");

    if (!responseCommandeNumber.ok) {
        alert("impossible de récupérer le numéro de commandes." +
            "\n inspectez la console pour plus d'informations");
        console.error(await responseCommandeNumber.json());
    }

    const commandeNumber = await responseCommandeNumber.json();

    //Rendu
    const commandeHeader =document.getElementById("commande-header");
    commandeHeader.innerHTML = CommandeHeader(commandeNumber, clients, livreurs);

    const pizzaTable = document.getElementById("pizza-table");
    pizzaTable.innerHTML = TableauPizza(pizzas);

    const commandeFooter =document.getElementById("commande-footer");
    commandeFooter.innerHTML = SubmitButton();
}

function CommandeHeader(numCommande, clients, livreurs) {
    return `
        <div>
            <div>
                <label>Numéro commande</label>
                <div>${numCommande + 1}</div>
            </div>
            <div>
                <label>Clients</label>
                <select id="client-select">
                    ${clients.map((client) => {
                        return `
                            <option value="${client.id}">${client.nom}</option>
                        `;
                    })}
                </select>
            </div>
            <div>
                <label>Livreurs</label>
                <select id="livreur-select">
                    ${livreurs.map((livreur) => {
                        return `
                            <option value="${livreur.id}">${livreur.nom}</option>
                        `;
                    })}
                </select>
            </div>
        </div>
    `;
}

function TableauPizza(pizzas) {
    return `
        <div>
            <table>
                <thead>
                    <tr>
                        <th>
                            Numero
                        </th>
                        <th>
                            Nom
                        </th>
                        <th>
                            Nombre de personnes
                        </th>
                        <th>
                            Prix
                        </th>
                        <th>
                            Quantité
                        </th>
                        <th>
                            Quantité sélectionnée
                        </th>
                        <th>
                            total prix (€)
                        </th>
                    </tr>
                </thead>
                <tbody>
                    ${pizzas.map((pizza) => {
                        return RowPizza(pizza);
                    }).join("")}
                </tbody>
            </table>
        </div>
    `;
}

function RowPizza(pizza) {
    return `
        <tr>
            <th>
                ${pizza.numero}
            </th>
            <th>
                ${pizza.nom}
            </th>
            <th>
                ${pizza.nbPers}
            </th>
            <th>
                ${pizza.prix}€
            </th>
            <th>
                <input type="range">
            </th>
            <th>
                quantite
            </th>
            <th>
                total prix
            </th>
        </tr>
    `;
}

function SubmitButton() {
    return `
        <button onclick="submitCommande()">ajouter commande</button>
    `
}

function submitCommande() {
    
}