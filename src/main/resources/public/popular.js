const movieCardsContainer = document.getElementById('movie-cards');

async function fetchMoviePoster(posterLink) {
    return fetch(posterLink)
        .then(response => {
            if (response.ok) {
                return posterLink;
            } else {
                return 'no-cover.png';
            }
        })
        .catch(error => {
            return 'no-cover.png';
        });
};

async function updateMovieCards(movies) {
    movieCardsContainer.innerHTML = '';
    for (const movie of movies) {
        const posterUrl = await fetchMoviePoster(movie.posterLink);
        const card = `
            <div class="col-md-3 col-sm-6 mb-4">
                <div class="card h-100">
                    <div class="card-img-top-wrapper">
                        <img src="${posterUrl}" class="card-img-top" alt="${movie.title}">
                    </div>
                    <div class="card-body d-flex flex-column">
                        <div class="mt-auto">
                            <!-- Additional content or actions can go here -->
                        </div>
                        <div>
                            <a href=${movie.imdbID}>
                                <h5 class="card-title">${movie.title}</h5>
                            </a>
                            <p class="card-text">${movie.genres}</p>
                        </div>
                    </div>
                </div>
            </div>
            `;
        movieCardsContainer.innerHTML += card;
    }
};

// fetch('/users/recommendations')
fetch('/movies')
    .then(response => response.json())
    .then(data => updateMovieCards(data));