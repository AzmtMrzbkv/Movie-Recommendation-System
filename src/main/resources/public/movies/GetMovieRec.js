const form = document.getElementById('search-form');
const resultsContainer = document.getElementById('results-container');

async function fetchMoviePoster(posterLink) {
    return fetch(posterLink)
        .then(response => {
            if (response.ok) {
                return posterLink;
            } else {
                return '../no-cover.png';
            }
        })
        .catch(error => {
            return '../no-cover.png';
        });
};

async function displayResults(movies) {
    resultsContainer.innerHTML = '';

    let html = `
            <div class="row justify-content-center">
                <div class="col-12 text-center">
                    <h3 class="mb-4">Recommended Movies</h3>
                </div>
            </div>
            `;

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
        html += card;
    }
    resultsContainer.innerHTML = html;
}

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const title = document.getElementById('title').value;
    const limit = document.getElementById('limit').value;

    const base_url = 'http://localhost:8080/movies/recommendations';
    let query = `?title=${title}`;
    if(limit !== '')
    {
        query += `&limit=${limit}`;
    }

    try {
        // const response = await fetch(base_url + limit);
        const response = await fetch(`http://localhost:8080/movies/`);

        if (response.ok) {
            const movies = await response.json();
            displayResults(movies);
        } else {
            console.error('Error fetching recommendations:', response.status);
            resultsContainer.innerHTML = '<p>Error fetching recommendations. Please try again later.</p>';
        }
    } catch (error) {
        console.error('Error fetching recommendations:', error);
        resultsContainer.innerHTML = '<p>Error fetching recommendations. Please try again later.</p>';
    }
});