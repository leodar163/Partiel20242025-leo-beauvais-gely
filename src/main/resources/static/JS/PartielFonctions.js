window.onload = () => {
    afficherPageCommande();
};

async function afficherPageCommande() {
    const responseClients = await fetch("/clients");

    if (!responseClients.ok) {
        alert("impossible de récupérer les clients." +
            "\n inspectez la console pour plus d'informations");
        console.error(await responseClients.json());
    }

    const clients = await responseClients.json();

    const responseLivreurs= await fetch("/livreurs");

    if (!responseLivreurs.ok) {
        alert("impossible de récupérer les livreurs. " +
            "\n inspectez la console pour plus d'informations");
        console.error(await responseLivreurs.json());
    }

    const livreurs= await responseLivreurs.json();

    const commandeHeader =document.getElementById("commande-header");
    commandeHeader.innerHTML = CommandeHeader(0, clients, livreurs);
}

function CommandeHeader(numCommande, clients, livreurs) {
    return `
        <div>
            <div>
                <label>Numéro commande</label>
                <div>${numCommande}</div>
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