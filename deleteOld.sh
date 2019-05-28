registry='dockerlab.dke.univie.ac.at:5000'
curl -v -sSL -X DELETE "http://${registry}/v2/${1}/manifests/$(
    curl -sSL -I \
        -H "Accept: application/vnd.docker.distribution.manifest.v2+json" \
        "http://${registry}/v2/${1}/manifests/$(
            curl -sSL "http://${registry}/v2/${1}/tags/list" | jq -r '.tags[0]'
        )" \
    | awk '$1 == "Docker-Content-Digest:" { print $2 }' \
    | tr -d $'\r' \
)"