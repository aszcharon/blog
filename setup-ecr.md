# ECR 및 GitHub Actions 설정 가이드

## 1. ECR 리포지토리 생성

AWS CLI로 ECR 리포지토리 생성:
```bash
aws ecr create-repository \
    --repository-name charon-blog \
    --region ap-northeast-2
```

또는 AWS 콘솔에서:
1. ECR 서비스 이동
2. "리포지토리 생성" 클릭
3. 리포지토리 이름: `charon-blog`
4. 리전: `ap-northeast-2`

## 2. GitHub Secrets 설정

GitHub 저장소 → Settings → Secrets and variables → Actions에서 추가:

### 필수 Secrets:
- `AWS_ACCESS_KEY_ID`: AWS 액세스 키 ID
- `AWS_SECRET_ACCESS_KEY`: AWS 시크릿 액세스 키

### AWS 자격증명 생성 방법:
1. AWS IAM 콘솔 이동
2. "사용자" → "사용자 추가"
3. 사용자 이름: `github-actions-ecr`
4. 권한: `AmazonEC2ContainerRegistryFullAccess` 정책 연결
5. 액세스 키 생성 → GitHub Secrets에 추가

## 3. 워크플로우 동작

- `master` 또는 `main` 브랜치에 푸시할 때 자동 실행
- Maven으로 JAR 파일 빌드
- Docker 이미지 빌드
- ECR에 이미지 푸시 (commit SHA 태그 + latest 태그)

## 4. 이미지 URI 형식

```
{AWS_ACCOUNT_ID}.dkr.ecr.ap-northeast-2.amazonaws.com/charon-blog:latest
{AWS_ACCOUNT_ID}.dkr.ecr.ap-northeast-2.amazonaws.com/charon-blog:{COMMIT_SHA}
```