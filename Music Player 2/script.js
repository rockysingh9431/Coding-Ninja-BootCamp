const songs = [
  // Array of song objects with properties: id, name, artist, img, genre, and src
  {
    id: 1,
    name: "Balam-Pichkari",
    artist: "Arijit Singh",
    img: "thumbnails/Balam Pichkaari.jpg",
    genre: "Dance",
    src: "songs/Balam-Pichkari(PaglaSongs).mp3",
  },
  {
    id: 2,
    name: "Faded",
    artist: "Alan Walker",
    img: "thumbnails/faded.jpg",
    genre: "Hip-Hop",
    src: "songs/Faded.mp3",
  },
  {
    id: 3,
    name: "Goriya Churana",
    artist: "Sonu Nigam, Alka Yagnik",
    img: "thumbnails/Goriya Churana.jpg",
    genre: "Pop",
    src: "songs/Goriya-Churana-Mera-Jiya(PaglaSongs).mp3",
  },
  {
    id: 4,
    name: "Heeriye",
    artist: "Arijit Singh",
    img: "thumbnails/heeriye.jpg",
    genre: "Jazz",
    src: "songs/Heeriye(PaglaSongs).mp3",
  },
  {
    id: 5,
    name: "Holi Biraj Ma",
    artist: "Jubin Nautiyal",
    img: "thumbnails/Holi biraj ma.jpg",
    genre: "Hip Hop",
    src: "songs/Holi-Biraj-Ma(PaglaSongs).mp3",
  },
  {
    id: 6,
    name: "Maan Meri Jaan",
    artist: "Don't Know",
    img: "thumbnails/maan meri jaan.jpg",
    genre: "Pop",
    src: "songs/Mana-Meri-Jaan(PaglaSongs).mp3",
  },
  {
    id: 7,
    name: "Sajni Re",
    artist: "Arijit Singh",
    img: "thumbnails/sajni re.jpg",
    genre: "Rock",
    src: "songs/Sajni-Re.mp3",
  },
];

// Function to toggle light/dark theme
function toggleTheme() {
  const rootNode = document.documentElement;
  const currentBgColor = rootNode.style.getPropertyValue("--bg-color");
  if (
    !currentBgColor ||
    currentBgColor ===
      "linear-gradient(45deg, rgb(255, 255, 129), rgb(253, 251, 233))"
  ) {
    rootNode.style.setProperty(
      "--bg-color",
      "linear-gradient(45deg, rgb(110, 5, 5), rgb(44, 0, 0))"
    );
    rootNode.style.setProperty("--text-color", "white");
    rootNode.style.setProperty(
      "--btn-color",
      "linear-gradient(45deg, rgba(80, 21, 102, 0.619), rgb(214, 31, 31))"
    );
  } else {
    rootNode.style.setProperty(
      "--bg-color",
      "linear-gradient(45deg, rgb(255, 255, 129), rgb(253, 251, 233))"
    );
    rootNode.style.setProperty("--text-color", "black");
    rootNode.style.setProperty(
      "--btn-color",
      "linear-gradient(45deg, rgb(249, 132, 100), rgb(255, 250, 119))"
    );
  }
}

// Function to filter and display songs by genre
function filterSongsGenre() {
  showSongs(songs); // Show all songs initially
  document
    .getElementById("select-genre")
    .addEventListener("change", (event) => {
      const selectedGenre = event.target.value;
      if (selectedGenre === "All") {
        showSongs(songs); // Show all songs if "All" is selected
      } else {
        const filteredSongs = songs.filter(
          (song) => song.genre === selectedGenre
        );
        showSongs(filteredSongs); // Show filtered songs based on selected genre
      }
    });
}

// Function to display songs in the DOM
function showSongs(songs) {
  const songList = document.getElementById("song-list");
  songList.innerHTML = ""; // Clear the current song list
  const songElements = renderSongs(songs, false); // Create song elements
  songList.appendChild(songElements); // Append song elements to the DOM
}

// Function to create song elements
function renderSongs(songs, flag) {
  const songListElement = document.createElement("div");
  songs.forEach((song) => {
    const songDetail = document.createElement("div");
    songDetail.classList.add("song-detail");

    const songElement = document.createElement("div");
    songElement.classList.add("song");
    songElement.innerHTML += `
      <div class="song-img">
        <img src="${song.img}" alt="${song.name}">
      </div>
      <div class="song-description">
        <div id="songName" class="name">${song.name}</div>
        <div class="art-name">${song.artist}</div>
      </div>`;

    // Create the delete button if flag is true
    if (flag) {
      const deleteBtn = document.createElement("button");
      deleteBtn.innerHTML = `<i class="fa-solid fa-trash "></i>`;
      deleteBtn.classList.add("remove-btn");
      deleteBtn.addEventListener("click", (event) => {
        event.stopPropagation(); // Prevent the click from propagating to the song element
        removeFromPlaylist(song);
      });

      songDetail.append(songElement, deleteBtn);
      songListElement.appendChild(songDetail);
    } else {
      songListElement.appendChild(songElement);
    }

    // Attach click event listener to the song element
    songElement.addEventListener("click", () => {
      renderCurrentSong(song);
      showSongDetails(song);
    });
  });
  return songListElement;
}

// Function to play the selected song
function renderCurrentSong(song) {
  const audio = document.getElementById("audio");
  if (audio.src !== song.src || audio.paused) {
    audio.src = song.src; // Set the source of the audio element
    audio.play(); // Play the audio
    renderPlaylistSong(song); // Update the playlist with the current song
    document.getElementById("addBtn").addEventListener("click", (e) => {
      e.stopPropagation();
      addToPlaylist(song); // Add the song to the playlist
    });
  }
}

// Function to display song details
function showSongDetails(song) {
  const songInfoElement = document.getElementById("song-info");
  songInfoElement.innerHTML = `
    <div class="thumbnail">
      <img src="${song.img}" alt="${song.name}">
    </div>
    <div class="song-name">${song.name}</div>
    <div class="artist-name">${song.artist}</div>
  `;
}

// Event listeners for next and previous buttons
document.getElementById("next-btn").addEventListener("click", nextSong);
document.getElementById("prev-btn").addEventListener("click", prevSong);

// Function to play the next song
function nextSong() {
  const audio = document.getElementById("audio");
  if (audio.src) {
    let song = songs.find((song) => audio.src.endsWith(song.src));
    if (song && song.id !== songs.length) {
      let nextSong = songs.find((s) => s.id === song.id + 1);
      if (nextSong) {
        renderCurrentSong(nextSong); // Play the next song
        showSongDetails(nextSong); // Show details of the next song
      }
    }
  }
}

// Function to play the previous song
function prevSong() {
  const audio = document.getElementById("audio");
  if (audio.src) {
    let song = songs.find((song) => audio.src.endsWith(song.src));
    if (song && song.id !== 1) {
      let prevSong = songs.find((s) => s.id === song.id - 1);
      if (prevSong) {
        renderCurrentSong(prevSong); // Play the previous song
        showSongDetails(prevSong); // Show details of the previous song
      }
    }
  }
}

// Function to create and display the current playlist
let currPlaylist = [];
function renderPlaylistSong(song) {
  // Only update the playlist if it's empty (i.e., the first song is added)
  if (currPlaylist.length === 0) {
    currPlaylist = songs.filter(
      (s) =>
        (s.genre === song.genre && s.name !== song.name) ||
        (s.artist === song.artist && s.name !== song.name)
    );
  }
  updatePlaylist();
}

// Function to update the current playlist
function updatePlaylist() {
  const playlist = document.getElementById("current-playlist");
  playlist.innerHTML = ""; // Clear the current playlist
  const playlistElements = renderSongs(currPlaylist, true); // Create playlist elements
  playlist.appendChild(playlistElements); // Append playlist elements to the DOM
}

// Function to add a song to the playlist
function addToPlaylist(song) {
  if (!currPlaylist.some((s) => s.id === song.id)) {
    currPlaylist.push(song); // Add the song to the playlist if it's not already there
    updatePlaylist();
  }
}

// Function to remove a song from the playlist
function removeFromPlaylist(song) {
  currPlaylist = currPlaylist.filter((s) => s.id !== song.id); // Remove the song from the playlist
  updatePlaylist();
}
// Initialize an empty array to store playlist names
let allPlaylist = [];

// Function to create a new playlist
function createPlaylist() {
  // Get the playlist container element and the input element for the playlist name
  const playlist = document.getElementById("all-playlist");
  const playListInputEle = document.getElementById("playlist-input");

  // Get the trimmed value of the input and clear the input field
  const playListInput = playListInputEle.value.trim();
  playListInputEle.value = "";

  // If the input is not empty, add the new playlist
  if (playListInput !== "") {
    // Add the new playlist to the allPlaylist array
    allPlaylist.push(playListInput);

    // Create a new div element to display the playlist and append it to the playlist container
    const newPlaylist = document.createElement("div");
    newPlaylist.classList.add("newPlaylist");
    newPlaylist.textContent = playListInput;
    playlist.appendChild(newPlaylist);
  }
}

// Function to search for songs based on input
function searchSong() {
  // Get the search input element and its trimmed value, then clear the input field
  const searchInputEle = document.getElementById("search-input");
  const searchInput = searchInputEle.value.trim();
  searchInputEle.value = "";

  // If the search input is not empty, filter the songs based on name or artist
  if (searchInput) {
    const filteredSongs = songs.filter(
      (song) =>
        song.name.toLowerCase().includes(searchInput.toLowerCase()) ||
        song.artist.toLowerCase().includes(searchInput.toLowerCase())
    );

    // Log the filtered songs and display them
    console.log(filteredSongs);
    showSongs(filteredSongs, false);
  }
}

// Function to search for playlists based on input
function searchPlaylist() {
  // Get the search input element and its trimmed value, then clear the input field
  const searchInputEle = document.getElementById("search-input");
  const searchInput = searchInputEle.value.trim();
  searchInputEle.value = "";

  // Get the playlist container element and clear its contents
  const playListEle = document.getElementById("all-playlist");
  playListEle.innerHTML = "";

  // If the search input is not empty, find and display the matching playlist
  if (searchInput) {
    let filteredPlaylist = allPlaylist.find(
      (playlist) => searchInput === playlist
    );

    // Create a new div element to display the filtered playlist and append it to the playlist container
    const newPlaylist = document.createElement("div");
    newPlaylist.classList.add("newPlaylist");
    newPlaylist.textContent = filteredPlaylist;
    playListEle.appendChild(newPlaylist);
  }
}

// Event listeners for search buttons and playlist button
document
  .getElementById("search-btn-playlist")
  .addEventListener("click", searchPlaylist);
document
  .getElementById("search-btn-song")
  .addEventListener("click", searchSong);
document
  .getElementById("add-playlist-btn")
  .addEventListener("click", createPlaylist);

// Initial setup: event listener for theme toggle button and initial song display
document.getElementById("toggle-theme").addEventListener("click", toggleTheme);
filterSongsGenre();
showSongDetails(songs[0]);
