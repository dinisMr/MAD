package com.example.lisbonapp.data

// ─────────────────────────────────────────────
//  🗂️ SAMPLE DATA
//
//  In a real app, this data would come from a server or database.
//  For learning purposes we hard-code 15 Lisbon places —
//  3 places for each of the 5 categories.
// ─────────────────────────────────────────────
object SampleData {

    /**
     * The master list of all 15 Lisbon places.
     */
    val places: List<Place> = listOf(

        // ══════════════════════════════════════════
        //  ☕ COFFEE SHOPS (3 places)
        // ══════════════════════════════════════════

        Place(
            id              = 1,
            name            = "Café A Brasileira",
            description     = "Historic Chiado café famous for its art deco facade and Fernando Pessoa statue.",
            fullDescription = "Opened in 1905, Café A Brasileira is one of Lisbon's oldest and most famous cafés. " +
                "Located in the bustling Chiado district, it served as a meeting point for intellectuals, " +
                "artists, and writers, including the legendary poet Fernando Pessoa. Enjoy a traditional " +
                "bica (espresso) on the outdoor terrace next to Pessoa's bronze statue!",
            location        = "Chiado",
            address         = "Rua Garrett 120, Chiado",
            category        = Category.COFFEE_SHOPS,
            rating          = 4.6f,
            openingHours    = "08:00 – 00:00"
        ),

        Place(
            id              = 2,
            name            = "Fábrica Coffee Roasters",
            description     = "Pioneering specialty coffee roastery with direct trade beans roasted in-house.",
            fullDescription = "Fábrica Coffee Roasters helped launch Lisbon's modern third-wave specialty " +
                "coffee scene. They import high-quality green beans directly from farmers worldwide and roast " +
                "them locally. Their industrial-chic cafes offer exceptional espresso, pour-overs, cold brew, " +
                "and delicious brunch items.",
            location        = "Bairro Alto / Baixa",
            address         = "Rua do Comércio 111, Baixa",
            category        = Category.COFFEE_SHOPS,
            rating          = 4.7f,
            openingHours    = "08:00 – 18:00"
        ),

        Place(
            id              = 3,
            name            = "Bettina & Niccolò Corallo",
            description     = "Charming family-owned chocolate café serving pure cacao and specialty coffee.",
            fullDescription = "A chocolate lover's paradise in Principe Real. Run by a family of cacao " +
                "growers and chocolate experts, this small café serves some of the finest single-estate " +
                "chocolates alongside rich, meticulously brewed espresso. Order a cup of coffee and enjoy " +
                "it with a complimentary piece of their legendary chocolate cake.",
            location        = "Príncipe Real",
            address         = "Rua da Escola Politécnica 4, Príncipe Real",
            category        = Category.COFFEE_SHOPS,
            rating          = 4.8f,
            openingHours    = "11:00 – 19:00"
        ),

        // ══════════════════════════════════════════
        //  🍽️ RESTAURANTS (3 places)
        // ══════════════════════════════════════════

        Place(
            id              = 4,
            name            = "Cervejaria Ramiro",
            description     = "World-famous seafood temple serving fresh shellfish and iconic steak sandwiches.",
            fullDescription = "Established in 1956, Cervejaria Ramiro is a legendary Lisbon institution, " +
                "renowned globally for serving the freshest seafood in town. From giant tiger prawns and garlic " +
                "clams to goose barnacles, the food is simple, fresh, and unmatched. End your seafood feast the " +
                "local way — with a Prego (garlic steak sandwich)!",
            location        = "Intendente",
            address         = "Avenida Almirante Reis 1, Intendente",
            category        = Category.RESTAURANTS,
            rating          = 4.8f,
            openingHours    = "12:00 – 00:00"
        ),

        Place(
            id              = 5,
            name            = "Time Out Market (Mercado da Ribeira)",
            description     = "Bustling historic food hall showcasing Lisbon's top chefs and traditional dishes.",
            fullDescription = "Lisbon's historic 19th-century Mercado da Ribeira was transformed into a " +
                "massive food hall curated by Time Out. Under one roof, you'll find stands representing Lisbon's " +
                "finest restaurants, Michelin-starred chefs, regional cheese and ham counters, and traditional " +
                "pastel de nata stalls. It is a fantastic destination for sampling diverse Portuguese specialties.",
            location        = "Cais do Sodré",
            address         = "Av. 24 de Julho 49, Cais do Sodré",
            category        = Category.RESTAURANTS,
            rating          = 4.6f,
            openingHours    = "10:00 – 00:00"
        ),

        Place(
            id              = 6,
            name            = "Tasca do Chico",
            description     = "Historic tavern famous for raw, traditional Fado Vadio and local petiscos.",
            fullDescription = "For an authentic, atmospheric taste of Fado Vadio (amateur fado), head " +
                "to Tasca do Chico in Bairro Alto. This tiny, wood-paneled tavern is lined with historic " +
                "photos of fado legends. Sip local wine, enjoy traditional Portuguese tapas (petiscos) " +
                "like grilled chouriço, and listen to soulful, emotional fado performances.",
            location        = "Bairro Alto",
            address         = "Rua do Diário de Notícias 39, Bairro Alto",
            category        = Category.RESTAURANTS,
            rating          = 4.5f,
            openingHours    = "19:00 – 02:00"
        ),

        // ══════════════════════════════════════════
        //  🌿 PARKS (3 places)
        // ══════════════════════════════════════════

        Place(
            id              = 7,
            name            = "Parque Eduardo VII",
            description     = "Grand manicured park offering iconic geometric hedge views of Lisbon and the Tagus.",
            fullDescription = "Parque Eduardo VII is the largest park in central Lisbon. Known for its " +
                "symmetrical box hedges that run down a sloping hill, it offers stunning views of Marquês " +
                "de Pombal square and the Tagus River beyond. The park houses a large cold greenhouse " +
                "(Estufa Fria) filled with exotic plants and waterfalls.",
            location        = "São Sebastião",
            address         = "Alameda Cardeal Cerejeira, Lisbon",
            category        = Category.PARKS,
            rating          = 4.7f,
            openingHours    = "Open 24 hours"
        ),

        Place(
            id              = 8,
            name            = "Jardim da Estrela",
            description     = "Charming Romantic-era park with exotic trees, duck ponds, and a historic bandstand.",
            fullDescription = "Created in 1842, Jardim da Estrela is a beloved local green space situated " +
                "directly opposite the Basílica da Estrela. Designed in the style of an English romantic garden, " +
                "it features exotic plants, small lakes with ducks, playgrounds, and an ornate wrought-iron " +
                "bandstand from the 19th century. A perfect place to relax.",
            location        = "Estrela",
            address         = "Praça da Estrela, Lisbon",
            category        = Category.PARKS,
            rating          = 4.6f,
            openingHours    = "07:00 – 00:00"
        ),

        Place(
            id              = 9,
            name            = "Jardim Botânico de Lisboa",
            description     = "Hidden subtropical botanical garden featuring rare plants and towering palm avenues.",
            fullDescription = "Tucked away behind the lively streets of Príncipe Real, this historic " +
                "botanical garden was founded in 1878. Spanning four hectares, it holds a vast collection of " +
                "subtropical and tropical plants, a monumental avenue of palm trees, and Europe's first " +
                "butterfly greenhouse. It's a peaceful jungle oasis in the heart of the city.",
            location        = "Príncipe Real",
            address         = "Rua da Escola Politécnica 58, Príncipe Real",
            category        = Category.PARKS,
            rating          = 4.5f,
            openingHours    = "09:00 – 20:00"
        ),

        // ══════════════════════════════════════════
        //  🛍️ SHOPPING (3 places)
        // ══════════════════════════════════════════

        Place(
            id              = 10,
            name            = "Feira da Ladra (Thieves Market)",
            description     = "Lisbon's legendary historic flea market operating in Alfama since 1272.",
            fullDescription = "Feira da Ladra, meaning 'Thieves Market', is Lisbon's oldest and most famous " +
                "flea market, dating back to 1272. Held every Tuesday and Saturday in Alfama near the National " +
                "Pantheon, it features hundreds of vendors selling antiques, vintage tiles, books, coins, " +
                "second-hand clothing, and bizarre curiosities. Bartering is expected!",
            location        = "Alfama",
            address         = "Campo de Santa Clara, Alfama",
            category        = Category.SHOPPING,
            rating          = 4.6f,
            openingHours    = "Tue & Sat: 09:00 – 18:00"
        ),

        Place(
            id              = 11,
            name            = "LX Factory",
            description     = "Creative hub in a former industrial site packed with cool shops, art, and restaurants.",
            fullDescription = "LX Factory is a vibrant creative mini-city housed in a former 19th-century fabric " +
                "factory complex beneath the 25 de Abril Bridge. The industrial buildings have been converted " +
                "into trendy boutiques, design stores, art studios, cafes, and restaurants. Don't miss Ler Devagar, " +
                "one of the world's most beautiful bookstores.",
            location        = "Alcântara",
            address         = "Rua Rodrigues de Faria 103, Alcântara",
            category        = Category.SHOPPING,
            rating          = 4.7f,
            openingHours    = "09:00 – 23:00"
        ),

        Place(
            id              = 12,
            name            = "Embaixada",
            description     = "Breathtaking 19th-century Neo-Moorish palace turned boutique concept store.",
            fullDescription = "Embaixada is one of the most stunning shopping venues in Lisbon. Set inside " +
                "the Ribeiro da Cunha Palace, a 19th-century Neo-Moorish building, it has been transformed " +
                "into a concept gallery. It hosts independent Portuguese brands, showcasing local craftsmanship, " +
                "fashion, home decor, and contemporary art, all framed by majestic arches and grand staircases.",
            location        = "Príncipe Real",
            address         = "Praça do Príncipe Real 26, Príncipe Real",
            category        = Category.SHOPPING,
            rating          = 4.5f,
            openingHours    = "12:00 – 20:00"
        ),

        // ══════════════════════════════════════════
        //  🎠 KID-FRIENDLY (3 places)
        // ══════════════════════════════════════════

        Place(
            id              = 13,
            name            = "Oceanário de Lisboa",
            description     = "Stunning global aquarium, one of the largest in Europe, with a massive central ocean tank.",
            fullDescription = "The Lisbon Oceanarium is a world-class aquarium located in the modern Parque " +
                "das Nações. Designed by architect Peter Chermayeff, it features a colossal central tank " +
                "containing 5 million liters of saltwater, housing sharks, rays, barracudas, and a giant " +
                "sunfish. Dedicated habitats represent the Atlantic, Antarctic, Pacific, and Indian Oceans " +
                "— a magical experience for kids.",
            location        = "Parque das Nações",
            address         = "Esplanada Dom Carlos I, Parque das Nações",
            category        = Category.KID_FRIENDLY,
            rating          = 4.9f,
            openingHours    = "10:00 – 20:00"
        ),

        Place(
            id              = 14,
            name            = "Pavilhão do Conhecimento",
            description     = "Interactive science and technology museum featuring hands-on exhibits for children.",
            fullDescription = "The Pavilion of Knowledge is an interactive science museum located right next " +
                "to the Oceanarium. It features large themed areas where kids can conduct physics experiments, " +
                "build structures in a simulated construction site, explore optical illusions, and learn about " +
                "space. It is designed to spark curiosity and fun through active play.",
            location        = "Parque das Nações",
            address         = "Largo José Mariano Gago, Parque das Nações",
            category        = Category.KID_FRIENDLY,
            rating          = 4.7f,
            openingHours    = "Tue–Sun: 10:00 – 18:00"
        ),

        Place(
            id              = 15,
            name            = "Telecabine Lisboa (Lisbon Cable Car)",
            description     = "Scenic cable car ride along the Tagus River with panoramic views of the Vasco da Gama Bridge.",
            fullDescription = "The Lisbon Cable Car offers a scenic 8-minute ride floating 30 meters above the " +
                "Tagus River in Parque das Nações. Families can enjoy stunning panoramic views of the modern " +
                "riverfront district, the Vasco da Gama Tower, and the monumental 12km-long Vasco da Gama Bridge. " +
                "It is a thrilling and relaxing ride for children of all ages.",
            location        = "Parque das Nações",
            address         = "Passeio das Tágides, Parque das Nações",
            category        = Category.KID_FRIENDLY,
            rating          = 4.4f,
            openingHours    = "11:00 – 19:00"
        )
    )

    // ─────────────────────────────────────────
    //  Helper Functions
    // ─────────────────────────────────────────

    fun getPlacesByCategory(category: Category): List<Place> =
        places.filter { it.category == category }

    fun getPlaceById(id: Int): Place? =
        places.find { it.id == id }
}
